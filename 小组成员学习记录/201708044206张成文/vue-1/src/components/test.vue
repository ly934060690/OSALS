<template>
  <el-menu :default-active="activeIndex2" class="el-menu-demo" mode="horizontal" @select="handleSelect" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
    <el-menu-item index="1">处理中心</el-menu-item>
    <el-submenu index="2">
      <template slot="title">我的工作台</template>
      <el-menu-item index="2-1">选项1</el-menu-item>
      <el-menu-item index="2-2">选项2</el-menu-item>
      <el-menu-item index="2-3">选项3</el-menu-item>
    </el-submenu>
    <el-menu-item index="3">
      <a href="https://www.ele.me" target="_blank">订单管理</a>
    </el-menu-item>
  </el-menu>

</template>

<script>
  export default {
    data() {
      return {
        activeIndex: '1',
        activeIndex2: '1'
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>
<!--<template>
  <div>
    <el-time-picker
      is-range
      v-model="value"
      range-separator="-"
      start-placeholder="开始时间"
      end-placeholder="结束时间"
      placeholder="选择时间范围">
    </el-time-picker>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        value: [new Date(2016, 9, 10, 8, 40), new Date(2016, 9, 10, 9, 40)],

      };
    }
  }
</script>
<template>
  <div>
    <el-row class="tac">
      <el-col :span="4">
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-s-platform"></i>
              <span>服务大厅</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="1-1">在场服务</el-menu-item>
              <el-menu-item index="1-2">历史服务</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-s-tools"></i>
              <span>系统设置</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="1-1">权限管理</el-menu-item>
              <el-menu-item index="1-2">角色管理</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-user-solid"></i>
              <span>人员数据</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="1-1">人员数量</el-menu-item>
              <el-menu-item index="1-2">人员位置</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="4">
            <template slot="title">
              <i class="el-icon-message-solid"></i>
              <span>健康报警</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="1-1">心率报警</el-menu-item>
              <el-menu-item index="1-2">血压报警</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-col>
    </el-row>
  </div>
</template>
<script>
  export default {
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>
<template>
  <div>
    <el-col :span="2">
      <el-menu
        :default-active="this.$route.path"
        router mode="horizontal"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
        <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
          <template slot="title">
            <i class="el-icon-s-platform"></i>
            <span> {{ item.navItem }}</span>
          </template>

        </el-menu-item>


      </el-menu>
    </el-col>

    <router-view     class="menu-right"/>

  </div>
</template>
<script>
  export default {
    data() {
      return {
        navList:[
          {name:'/components/ServiceHall',navItem:'服务大厅'},
          {name:'/components/Management',navItem:'权限管理'},
          {name:'/components/User',navItem:'用户管理'},
          {name:'/components/Personnel',navItem:'人员数据'},
          {name:'/components/Alarm',navItem:'报警中心'},
        ] }
    },
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>

<style>
  .menu-right{
    margin-left:200px;
  }

</style>-->
