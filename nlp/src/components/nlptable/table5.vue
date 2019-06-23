
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
        <span style="margin-left: 10px">{{ getLocalTime(scope.row.creatTime) }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="text"
      width="180">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.text }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="THUCTC"
      width="160">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.classify1 }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="EasyDL"
      width="180">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.classify2 }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="FudanNLP"
      width="180">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.classify3 }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="fasttext"
      width="180">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.classify4 }}</span>
      </template>
    </el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <!--<el-button-->
        <!--size="mini"-->
        <!--@click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->

        <!-- Form -->
        <el-button type="primary" @click="dialogFormVisible = true" size="mini">新增</el-button>

        <el-dialog title="文本分类" :visible.sync="dialogFormVisible">
          <el-form :model="Form">
            <el-form-item label="text" :label-width="formLabelWidth">
              <el-input v-model="Form.text" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="THUCTC" :label-width="formLabelWidth">
              <el-input v-model="Form.classify1" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="EasyDL" :label-width="formLabelWidth">
              <el-input v-model="Form.classify2" autocomplete="off">
              </el-input>
            </el-form-item>
            <el-form-item label="FudanNLP" :label-width="formLabelWidth">
              <el-input v-model="Form.classify3" autocomplete="off">
              </el-input>
            </el-form-item>
            <el-form-item label="fasttext" :label-width="formLabelWidth">
              <el-input v-model="Form.classify4" autocomplete="off">
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
          @click="updateExpenditure(scope.$index, scope.row)">编辑</el-button>


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
          classify1: '',
          classify2: '',
          classify3: '',
          classify4: ''
        },
        formLabelWidth: '120px',
      }
    },
    methods: {
      update(index,row) {
      },
      postForm() {
        const url = this.HOST + '/nlptc/save';
        this.dialogFormVisible = false;

        var params = new URLSearchParams();
        params.append('goodName', this.epdtForm.goodName);
        params.append('dealByPersonName', this.epdtForm.dealByPersonName);
        params.append('dealMoney', this.epdtForm.dealMoney);

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
          .delete(this.HOST + '/sun/expenditure/info/' + expenditureId)
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
    created() {
      this.$axios.get(this.HOST+'/nlptc/all')

      //then获取成功；response成功后的返回值（对象）

        .then(response=>{

          console.log(response);

          this.tableData=response.data;

        })

        //获取失败

        .catch(error=>{

          console.log(error);

          alert('网络错误，不能访问');

        })

    }
  }
</script>
