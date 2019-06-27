
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
      label="EnwrapNames"
      width="180">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.name }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="telephone"
      width="160">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.telephone }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="级联关系"
      width="160">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.expresscarname }}</span>
      </template>
    </el-table-column>

    <el-table-column label="操作">
      <template slot-scope="scope">
        <!--<el-button-->
        <!--size="mini"-->
        <!--@click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->

        <!-- Form -->
        <el-button type="primary" @click="dialogFormVisible = true" size="mini">新增</el-button>

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
        tableData: [{
          name: 'enwrap_0',
          telephone: '011111',
          expresscarname:'expressCar_0_0'
        }, {
          name: 'enwrap_1',
          telephone: '111111',
          expresscarname:'expressCar_0_0'
        }, {
          name: 'enwrap_0',
          telephone: '011111',
          expresscarname:'expressCar_0_1'
        }, {
          name: 'enwrap_1',
          telephone: '111111',
          expresscarname:'expressCar_0_1'
        }, {
            name: 'enwrap_0',
            telephone: '011111',
            expresscarname:'expressCar_1_0'
          }, {
            name: 'enwrap_1',
            telephone: '111111',
            expresscarname:'expressCar_1_0'
          }, {
            name: 'enwrap_0',
            telephone: '011111',
            expresscarname:'expressCar_1_1'
          }, {
            name: 'enwrap_1',
            telephone: '111111',
            expresscarname:'expressCar_1_1'
          }],
        dialogTableVisible: false,
        dialogFormVisible: false,
        formLabelWidth: '120px',
        date:new Date(),
      }
    },
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      },

      //时间戳转化
      getLocalTime(nS) {
        return new Date(parseInt(nS) * 1000).toLocaleString().replace(/:\d{1,2}$/, ' ');
      },
      timeNow () {
        return moment().utc().format('YYYY年MM月DD日') + ' ' + moment().utc().format('dddd')
      }
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
