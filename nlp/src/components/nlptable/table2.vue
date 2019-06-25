
<template>
  <el-table
    :data="tableData"
    height="650px"
    style="width: 100%">
    <el-table-column
      label="日期"
      width="200">
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{ getLocalTime(scope.row.dateCreated) }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="text"
      width="180">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.sentence }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="HanLP"
      width="160">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.hanLP }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="StanfordNlp"
      width="180">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.stanford }}</span>
      </template>
    </el-table-column>

    <el-table-column label="操作">
      <template slot-scope="scope">
        <!--<el-button-->
        <!--size="mini"-->
        <!--@click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->

        <!-- Form -->
        <el-button type="primary" @click="dialogFormVisible = true" size="mini">新增</el-button>

        <el-dialog title="实体识别" :visible.sync="dialogFormVisible">
          <el-form :model="Form">
            <el-form-item label="sentence" :label-width="formLabelWidth">
              <el-input v-model="Form.sentence" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="hanLP" :label-width="formLabelWidth">
              <el-input v-model="Form.hanLP" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="stanfordNlp" :label-width="formLabelWidth">
              <el-input v-model="Form.stanford" autocomplete="off">
              </el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="postForm">确 定</el-button>
          </div>
        </el-dialog>

        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">删除</el-button>


        <el-button
          type="success"
          size="mini"
          @click="update(scope.$index, scope.row)">修改</el-button>

      </template>
    </el-table-column>
  </el-table>
</template>

<script>
  export default {
    data() {
      return {
        tableData: [],
        dialogTableVisible: false,
        dialogFormVisible: false,
        Form: {
          sentence: '',
          stanford: '',
          hanLP: '',
        },
        formLabelWidth: '120px',
      }
    },
    methods: {
      update(index,row) {
        this.$prompt('请输入要改变的word:', '修改', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
        }).then(({value}) => {
          this.$message({
            type: 'success',
            message: '已保存: '
          });
          var Expenditure={"id": row.id, "dealMoney": value};
          console.log(Expenditure);
          this.$axios({
            method: "put",
            url:this.HOST + '/nlperg/save',
            data:{
              Expenditure
            },
            headers: {
              'Content-Type': 'application/json;charset=UTF-8'
            }
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '取消输入'
          });
        });
      },
      postForm() {
        const url = this.HOST + '/nlperg/save';
        this.dialogFormVisible = false;

        var params = new URLSearchParams();
        params.append('sentence', this.Form.sentence);
        params.append('hanLP', this.Form.hanLP);
        params.append('stanford', this.Form.stanford);

        console.log(params);
        this.$axios({
          method: 'post',
          url: url,
          data: params
        })

          .then(function (response) {

            console.log(response);

          })

          .catch(function (error) {

            console.log(error);

          });
      },
      handleEdit(index, row) {
        console.log(index, row);

      },
      handleDelete(index, row) {
        console.log(index, row);
        var expenditureId = row.id;
        console.log(expenditureId);
        this.$axios
          .delete(this.HOST + '/nlperg/delete/' + expenditureId)
          .then(res => {
            console.log(res);
            this.tableData.splice(index, 1)
          })
          .catch(err => {
            console.log(err);
          });
      },

      //时间戳转化
      getLocalTime(nS) {
        return new Date(parseInt(nS) ).toLocaleString().replace(/:\d{1,2}$/, ' ');
      }
    },
    created() {
      this.$axios.get(this.HOST+'/nlperg/all')
        .then(response=>{

          console.log(response);

          this.tableData=response.data;

        })
        .catch(error=>{

          console.log(error);

          alert('网络错误，不能访问');

        })

    }
  }
</script>
