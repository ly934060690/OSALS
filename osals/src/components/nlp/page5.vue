<template>
  <div>
    <h1 style="line-height:4px;">下面为文本分类：</h1>
    <h1 style="line-height:2px">*****:<input type="text"  class="qxs-ic_password qxs-icon"  v-bind:value="data1.username" style="width: 500px ; height: 25px"></h1>
    <h1 style="line-height:2px">*****:<input type="text"  class="qxs-ic_password qxs-icon"  v-bind:value="data2.username" style="width: 500px ; height: 25px"></h1>
    <h1 style="line-height:2px">*****:<input type="text"  class="qxs-ic_password qxs-icon"  v-bind:value="data3.username" style="width: 500px ; height: 25px"></h1>
    <h1 style="line-height:2px">*****:<input type="text"  class="qxs-ic_password qxs-icon"  v-bind:value="data4.username" style="width: 500px ; height: 25px"></h1>
    <h1 style="line-height:2px">*****:<input type="text"  class="qxs-ic_password qxs-icon"  v-bind:value="data5.username" style="width: 500px ; height: 25px"></h1>
    <h1 style="line-height:2px">*****:<input type="text"  class="qxs-ic_password qxs-icon"  v-bind:value="data6.username" style="width: 500px ; height: 25px"></h1>
    <h1 style="line-height:2px">*****:<input type="text"  class="qxs-ic_password qxs-icon"  v-bind:value="data7.username" style="width: 500px ; height: 25px"></h1>
    <h1 style="line-height:2px">*****:<input type="text"  class="qxs-ic_password qxs-icon"  v-bind:value="data8.username" style="width: 500px ; height: 25px"></h1>
    <el-button class="login_btn" @click.native="test1" type="primary" round :loading="isBtnLoading">刷新</el-button>
    <!--the @click.native is to call this function-->
    <!--the username from data1.username must keep up with the json property-->
    <router-view/>
  </div>
</template>

<script type="text/javascript">
  import axios from 'axios';
  export default {
    data() {
      return {
        //It like the statement of variables
        data1:{},
        data2:{},
        data3:{},
        data4:{},
        data5:{},
        data6:{},
        data7:{},
        data8:{},
      }
    },
    created() {
      //created like main function
      this.test1();
      //test1 must be this.
      alert(data1.username)
      //Can use alert to test your code
    },
    methods:{
      test1:function () {
        let that = this
        var url = this.HOST+"/user/response"
        //if you want to change the value of HOST ,please go to /osals/config/index.js/->module.exports->dev->proxyTable->target
        this.$axios.get(url)
          .then(function (res) {
            that.data1 = res.data;
            //this res.data is from the server's response
            console.log("成功获得data1");
          })
          .then(function (res) {
            console.log(res);
          })
      }
    }

  }
</script>
