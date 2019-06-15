<template>
  <div>

    <el-container >
        <el-header
          style="height: 100px">
          <img src="assets/logo/logo_nlp.png" align="left">
        </el-header>

        <el-container
          style="line-height: 100%">
          <el-aside
            width="200px">
            <el-menu
              style="width: 100%"
              default-active="$route.path"
              router="true"
              class="el-menu-vertical-demo"
              @open="handleOpen"
              @close="handleClose"
              background-color="#173d4a"
              text-color="#2f882c"
              active-text-color="#ffd04b">

              <el-menu-item index="/components/index/home">
                <i class="el-icon-menu"></i>
                <span slot="title">首页</span>
              </el-menu-item>

              <el-submenu index="2" >
                <template slot="title">
                  <i class="el-icon-location"></i>
                  <span>NLP</span>
                </template>
                <el-menu-item-group >
                  <el-menu-item index="/components/nlp/page1">分词标注</el-menu-item>
                  <el-menu-item index="/components/nlp/page2">实体抽取</el-menu-item>
                  <el-menu-item index="/components/nlp/page3">实体关系</el-menu-item>
                  <el-menu-item index="/components/nlp/page4">关键词提取</el-menu-item>
                  <el-menu-item index="/components/nlp/page5">文本分类</el-menu-item>
                  <el-menu-item index="/components/nlp/page6">依存关系</el-menu-item>
                  <el-menu-item index="/components/nlp/page7">摘要提取</el-menu-item>
                </el-menu-item-group>

              </el-submenu>
              <el-submenu index="3">
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

              <el-menu-item index="4" disabled>
                <i class="el-icon-document"></i>
                <span slot="title">危险</span>
              </el-menu-item>

              <el-menu-item index="5">
                <i class="el-icon-setting"></i>
                <span slot="title">关于</span>
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


<script>

</script>

<style>
  .el-header, .el-footer {
    background-color: #173d4a;
    color: #333;
    text-align: center;
    line-height: 200%;
  }

  .el-aside {
    background-color: #173d4a;
    color: #333;
    text-align: center;
    line-height: 500px;
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
