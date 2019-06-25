
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
        <span style="margin-left: 10px">{{date}}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="text"
      width="180">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.text}}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="HanLP"
      width="160">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.text1 }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="FoolNlp"
      width="180">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.text4}}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="StanfordNlp"
      width="180">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.text3}}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="AnsjNlp"
      width="180">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.text2}}</span>
      </template>
    </el-table-column>

    <el-table-column label="操作">
      <template slot-scope="scope">
        <!--<el-button-->
        <!--size="mini"-->
        <!--@click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->

        <!-- Form -->
        <el-button type="primary" @click="dialogFormVisible = true" size="mini">新增</el-button>

        <el-dialog title="实体关系" :visible.sync="dialogFormVisible">
          <el-form :model="Form">
            <el-form-item label="text" :label-width="formLabelWidth">
              <el-input v-model="Form.text" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="HanLP" :label-width="formLabelWidth">
              <el-input v-model="Form.text1" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="FoolNlp" :label-width="formLabelWidth">
              <el-input v-model="Form.text2" autocomplete="off">
              </el-input>
            </el-form-item>
            <el-form-item label="StanfordNlp" :label-width="formLabelWidth">
              <el-input v-model="Form.text3" autocomplete="off">
              </el-input>
            </el-form-item>
            <el-form-item label="AnsjNlp" :label-width="formLabelWidth">
              <el-input v-model="Form.text4" autocomplete="off">
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
          text: '',
          text1: '',
          text2: '',
          text3: '',
          text4: '',
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
            url:this.HOST + '/nlpae/save',
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
        const url = this.HOST + '/nlpae/save';
        this.dialogFormVisible = false;

        var params = new URLSearchParams();
        params.append('text', this.Form.text);
        params.append('text1', this.Form.text1);
        params.append('text2', this.Form.text2);
        params.append('text3', this.Form.text3);
        params.append('text4', this.Form.text4);
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
          .delete(this.HOST + '/nlpae/delete/' + expenditureId)
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
        return new Date(parseInt(nS) * 1000).toLocaleString().replace(/:\d{1,2}$/, ' ');
      }
    },
    timeNow () {
      return moment().utc().format('YYYY年MM月DD日') + ' ' + moment().utc().format('dddd')
    },
    created() {
      this.$axios.get(this.HOST+'/nlpae/all')
        .then(response=>{

          console.log(response);

          this.tableData=response.data;

        })
        .catch(error=>{

          console.log(error);

          alert('网络错误，不能访问');

        })
    },
    mounted() {
      let _this = this;
      this.timer = setInterval(function() {
        _this.date = new Date().toLocaleString();
      });
    },
    beforeDestroy: function() {
      if (this.timer) {
        clearInterval(this.timer);
      }
    },
  }

</script>
