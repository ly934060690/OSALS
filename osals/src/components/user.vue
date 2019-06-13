<template>
  <div style="padding:30px">
    <el-alert title="测试" :closable="false">
      <el-button @click="getcrfdata" type="success" round><i class="el-icon-refresh"></i>刷新</el-button>
    <router-view/>
    <div>

    </div>
      <div>
        <h2>{{datatest.string}}</h2>
      </div>
    </el-alert>
  </div>
</template>

<script type="text/javascript">
  import axios from 'axios';
  export default {
    name:'axiostest',
    data(){
      return {
        userData: {
        },
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
      this.getcrfdata()
      alert(this.datatest.username)
    },
    methods:{
      zz:function () {
        let that = this
        var url = this.HOST+"/user/test"

        this.$axios.get(url)
          .then(function (response) {
              console.log("此处显示信息");
              console.log("response.data.name:"+response.data.name);
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
        const path='http://localhost:8081/user/test';
        axios.get(path).then(function (response) {
          that.datatest=response.data;
          that.ss()
        }).catch(function (error) {
          alert('Error'+error)
        })
      },
      ss:function () {
        alert(this.datatest.username)
      }
    }
  }
</script>
