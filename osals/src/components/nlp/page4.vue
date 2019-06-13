<template>
  <div>
    <h1 style="line-height:4px;">下面为关键词提取：</h1>
    <h1 style="line-height:2px">hanlp:<input type="text"  class="qxs-ic_password qxs-icon"  v-model="text1" style="width: 500px ; height: 25px"></h1>
    <h1 style="line-height:2px">*****:<input type="text"  class="qxs-ic_password qxs-icon"  v-model="text2" style="width: 500px ; height: 25px"></h1>
    <h1 style="line-height:2px">*****:<input type="text"  class="qxs-ic_password qxs-icon"  v-model="text3" style="width: 500px ; height: 25px"></h1>
    <h1 style="line-height:2px">*****:<input type="text"  class="qxs-ic_password qxs-icon"  v-model="text4" style="width: 500px ; height: 25px"></h1>
    <h1 style="line-height:2px">*****:<input type="text"  class="qxs-ic_password qxs-icon"  v-model="text5" style="width: 500px ; height: 25px"></h1>
    <h1 style="line-height:2px">*****:<input type="text"  class="qxs-ic_password qxs-icon"  v-model="text6" style="width: 500px ; height: 25px"></h1>
    <h1 style="line-height:2px">*****:<input type="text"  class="qxs-ic_password qxs-icon"  v-model="text6" style="width: 500px ; height: 25px"></h1>
    <h1 style="line-height:2px">*****:<input type="text"  class="qxs-ic_password qxs-icon"  v-model="text6" style="width: 500px ; height: 25px"></h1>
    <h1><el-button class="login_btn" @click.native="postdata" type="primary" round :loading="isBtnLoading">刷新</el-button></h1>
  </div>
</template>

<script>
  import axios from 'axios';

  export default {
    data() {
      return {

      }
    },
    created() {
      this.test1()
    },
    methods:{
      test1:function () {
        let that = this
        var url = "http://localhost:8081/user/test"
      }
    }
  }
</script>
