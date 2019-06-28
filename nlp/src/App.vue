<template xmlns:img="http://www.w3.org/1999/xhtml">
  <div>

    <el-container >
        <el-header
          style="height: 134px">
          <img src="assets/logo_nlp.png" align="left"/>
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
                  <el-menu-item index="/components/nlp/page8">跳转按钮</el-menu-item>
                </el-menu-item-group>

              </el-submenu>
              <el-submenu index="3">
                <template slot="title">
                  <i class="el-icon-location"></i>
                  <span>导航二</span>
                </template>
                <el-menu-item-group >
                  <el-menu-item index="/components/nlptable/table1">分词标注</el-menu-item>
                  <el-menu-item index="/components/nlptable/table2">实体抽取</el-menu-item>
                  <el-menu-item index="/components/nlptable/table3">实体关系</el-menu-item>
                  <el-menu-item index="/components/nlptable/table4">关键词提取</el-menu-item>
                  <el-menu-item index="/components/nlptable/table5">文本分类</el-menu-item>
                  <el-menu-item index="/components/nlptable/table6">依存关系</el-menu-item>
                  <el-menu-item index="/components/nlptable/table7">跳转按钮</el-menu-item>
                </el-menu-item-group>
              </el-submenu>

              <el-submenu index="3">
                <template slot="title">
                  <i class="el-icon-location"></i>
                  <span>实体部分</span>
                </template>
                <el-menu-item-group >
                  <el-menu-item index="/components/table/goods">货物</el-menu-item>
                  <el-menu-item index="/components/table/warehouse">仓库</el-menu-item>
                  <el-menu-item index="/components/table/expresscar">快递车</el-menu-item>
                  <el-menu-item index="/components/table/enwrap">包裹</el-menu-item>
                  <el-menu-item index="/components/table/order">订单</el-menu-item>
                  <el-menu-item index="/components/table/ordergoods">订单中的商品</el-menu-item>
                  <el-menu-item index="/components/table/courier">快递员</el-menu-item>
                  <el-menu-item index="/components/table/courierCompany">快递公司</el-menu-item>
                  <el-menu-item index="/components/table/car">货车</el-menu-item>
                  <el-menu-item index="/components/table/driver">司机</el-menu-item>
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
