<template>
  <el-table
    :data="tableData"
    height="650px"
    style="width: 100%">
    <el-table-column
      label="日期"
      width="180">
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{date}}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="编号"
      width="160">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.driNum }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="姓名"
      width="120">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.driName}}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="级联关系"
      width="120">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.car.carNum}}</span>
      </template>
    </el-table-column>

    <el-table-column label="操作">
      <template slot-scope="scope">
        <!--<el-button-->
        <!--size="mini"-->
        <!--@click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->

        <!-- Form -->
        <el-button type="primary" @click="dialogFormVisible = true" size="mini">新增</el-button>

        <el-dialog title="司机" :visible.sync="dialogFormVisible">
          <el-form :model="Form">
            <el-form-item label="司机编号" :label-width="formLabelWidth">
              <el-input v-model="Form.driNum" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="司机姓名" :label-width="formLabelWidth">
              <el-input v-model="Form.driName" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="所属货车编号" :label-width="formLabelWidth">
              <el-input v-model="Form.car.carNum" autocomplete="off"></el-input>
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
          driNum: '',
          driName: '',
          car:{
            carNum: '',
          }
        },
        formLabelWidth: '120px',
        date:new Date(),
      }
    },
    methods: {
      update(index,row) {

      },
      postForm() {
        const url = this.HOST + '/driver/save';
        this.dialogFormVisible = false;

        var params = new URLSearchParams();
        params.append('driNum', this.Form.driNum);
        params.append('driName', this.Form.driName);
        params.append('car.carId', this.Form.car.carNum);

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
        var Id = row.id;
        console.log(Id);
        this.$axios
          .delete(this.HOST + '/driver/delete/' + Id)
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
      },
      timeNow () {
        return moment().utc().format('YYYY年MM月DD日') + ' ' + moment().utc().format('dddd')
      }
    },

    created() {
      this.$axios.get(this.HOST+'/driver/all')
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

