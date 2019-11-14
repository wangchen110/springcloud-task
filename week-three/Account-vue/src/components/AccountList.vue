<template>
  <el-main>
    <template>
      <el-form :model="searchForm" label-width="80px">
        <el-form-item>
          时间：:
          <el-input v-model="searchForm.created" type="date" placeholder="开始时间" style="width: 200px"
                    clearable></el-input>
          -
          <el-input v-model="searchForm.endtime" type="date" placeholder="结束时间" style="width: 200px"
                    clearable></el-input>
          <el-button @click="list()">查询</el-button>
        </el-form-item>
      </el-form>
      <el-table
        :data="tableData"
        style="width: 100%">
        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="创建时间">
                <el-input v-model.number=" props.row.created"></el-input>
              </el-form-item>
              <el-form-item label="所属店铺">
                <span>{{ props.row.price }}</span>
              </el-form-item>
              <el-form-item label="商品 ID">
                <span>{{ props.row.id }}</span>
              </el-form-item>
              <el-form-item label="店铺 ID">
                <span>{{ props.row.shopId }}</span>
              </el-form-item>
              <el-form-item label="商品分类">
                <span>{{ props.row.category }}</span>
              </el-form-item>
              <el-form-item label="店铺地址">
                <span>{{ props.row.address }}</span>
              </el-form-item>
              <el-form-item label="商品描述">
                <span>{{ props.row.desc }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column
          label="时间"
          prop="created">
        </el-table-column>
        <el-table-column
          label="分类"
          prop="type">
        </el-table-column>
        <el-table-column
          label="金额"
          prop="price">
        </el-table-column>
        <el-table-column
          label="账户"
          prop="name">
        </el-table-column>
        <el-table-column
          label="备注"
          prop="note">
        </el-table-column>
      </el-table>
      <span>支出总金额：{{expenditure}},收入总金额：{{income}}</span>
      <div class="block">
        <el-pagination
          @current-change="handleCurrentChange"
          :page-count="pages">
        </el-pagination>
      </div>
    </template>
  </el-main>
</template>

<script>
  const axios = require("axios");
  axios.defaults.baseURL = 'http://localhost:10010/account-service';

  export default {
    name: "AccountList",
    data() {
      return {
        searchForm: {
          pageNum: 1,
          pageSize: 3
        },
        income: 1,
        expenditure: 1,
        pages: 1,
        tableData: {}
      }
    },
    methods: {
      handleCurrentChange(val) {
        this.searchForm.pageNum = val;
        this.list();
      },
      list() {
        let self = this;
        axios({
          url: "/list",
          method: "get",
          params: this.searchForm
        }).then(function (obj) {
          console.log(obj.data);
          self.tableData = obj.data.pageInfo.list;
          self.pages = obj.data.pageInfo.pages;
          self.expenditure = obj.data.expenditure
          self.income = obj.data.income

        })
      }
    },
    created() {
      let params = this.$route;
      console.log(params);
      this.list();
    }
  }
</script>

<style>
  .demo-table-expand {
    font-size: 0;
  }

  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }

  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>
