<template>
  <div style="padding:30px">
    <el-input  v-bind:value="datatest.username" placeholder="请输入内容"></el-input>

    <el-button @click="getcrfdata" type="success" round><i class="el-icon-refresh"></i>刷新</el-button>
    <router-view/>
  </div>
</template>

<script type="text/javascript">
  import axios from 'axios';
  export default {
    name:'axiostest',
    data(){
      return {
        userData:{},
        sites:{},
        datatest:{}
      }
    },
    created() {
      // let that = this
      // var url = "http://localhost:8081/user/test"
      //
      // this.$axios.get(url)
      //   .then(function (response) {
      //       console.log("此处显示信息");
      //       console.log("response.data.name:"+response.data.name);
      //       that.userData = response.data;
      //       alert(that.userData.username)
      //       //this.userData.name="张成文";
      //       console.log("打印成功")
      //       console.log(response);
      //   }
      //   )
      //   .catch(error =>{
      //     console.log(error);
      //   })
      // this.getdata()
      this.getcrfdata();
      alert("11111"+this.datatest.username)
    },
    methods:{
      zz:function () {
        let that = this
        var url = this.HOST+"/user/response"

        this.$axios.get(url)
          .then(function (response) {
              console.log("此处显示信息");
              console.log("response.data.username:"+response.data.username);
              that.userData = response.data;
              // alert(that.userData.dateModified)
              //this.userData.name="张成文";
              console.log("打印成功")
              console.log(response);
            }
          )
          .catch(error =>{
            console.log(error);
          })
      },


      getcrfdata:function () {
        var that=this;
        const path='http://localhost:8081/user/response';
        axios.get(path).then(function (response) {
          that.datatest=response.data;
          that.ss()
        }).catch(function (error) {
          alert('Error'+error)
        })
      },
      ss:function () {
        alert("32222"+this.datatest.username)
      }
    }
  }
</script>
