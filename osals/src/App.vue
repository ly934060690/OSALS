<template>
  <div>

    <el-container>
      <el-header >
      </el-header>


      <el-container>
        <el-aside width="200px">
          <el-menu
            style="width: 100%"
            default-active="$route.path"
            router="true"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            background-color="#7dc6ca"
            text-color="#0400b4"
            active-text-color="#ffd04b">


            <el-submenu index="1" >
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>导航一</span>
              </template>
              <el-menu-item-group >
                <el-menu-item index="/components/page1">选项一</el-menu-item>
                <el-menu-item index="1-2">选项2</el-menu-item>
                <el-menu-item index="1-3">选项3</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>导航二</span>
              </template>
              <el-menu-item-group >
                <el-menu-item index="1-1">选项1</el-menu-item>
                <el-menu-item index="1-2">选项2</el-menu-item>
                <el-menu-item index="1-3">选项3</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-menu-item index="3">
              <i class="el-icon-menu"></i>
              <span slot="title">导航三</span>
            </el-menu-item>
            <el-menu-item index="4" disabled>
              <i class="el-icon-document"></i>
              <span slot="title">导航四</span>
            </el-menu-item>
            <el-menu-item index="5">
              <i class="el-icon-setting"></i>
              <span slot="title">导航五 </span>
            </el-menu-item>
          </el-menu>

        </el-aside>


        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>

  </div>
</template>


<style>
  .el-header, .el-footer {
    background-color: #677de3;
    color: #333;
    text-align: center;
    line-height: 200%;
  }

  .el-aside {
    background-color: #7dc6ca;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-main {
    background-color: #f5fff5;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
</style>
