<template>
  <el-main style="width: 600px" align="center">
    <el-radio-group v-model="a" @change="change(a)">
      <el-radio-button label="0">收入</el-radio-button>
      <el-radio-button label="1">支出</el-radio-button>
    </el-radio-group>
    <div style="margin: 20px;"></div>
    <el-form label-width="80px" :model="account">
      <el-form-item label="头像">
        <el-upload
          class="avatar-uploader"
          action="http://localhost:8081/upload"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload">
          <img width="100px" height="100px" v-if="account.imgurl" :src="account.imgurl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>
      <el-form-item label="金额">
        <el-input v-model.number="account.price"></el-input>
      </el-form-item>
      <el-form-item label="时间">
        <el-input v-model="account.created" type="date"></el-input>
      </el-form-item>
      <el-form-item label="活动区域">
        <el-select v-model="account.types" placeholder="请选择活动区域">
          <el-option v-for="t in typeList" :label="t.tname" :value="t.id" :key="t.id"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="备注">
        <el-input v-model="account.note"></el-input>
      </el-form-item>
      <router-link to="list">查看账单</router-link>
      <el-button @click="submit()">添加</el-button>
      <el-button @click="tolist()">查看账单</el-button>
    </el-form>
  </el-main>
</template>

<script>
  const axios = require("axios");
  axios.defaults.baseURL = 'http://localhost:10010/account-service';
  export default {
    name: "operation",
    data() {
      return {
        imageUrl: "",
        labelPosition: 'right',
        a: '0',
        account: {
          imgurl: ""
        },
        typeList: [],
        dialogImageUrl: '',
      }
    },
    methods: {
      tolist() {
        this.$router.push("list?id=1");
      },
      handleAvatarSuccess(res, file) {
        this.account.imgurl = res;
        this.imageUrl = res;
        console.log(res)

      },
      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;
      },
      submit() {
        let self = this;
        axios({
          url: "/saveAccount",
          method: "post",
          data: this.account
        }).then(function (obj) {
          self.$message(obj.data + "");
          self.account = {}
        })
      },
      change(typeId) {
        this.account = {};
        let self = this;
        axios.get('/listDateil?typeId=' + typeId).then(function (obj) {
          self.typeList = obj.data
        })
      }
    },
    created() {
      this.change(0)
    }
  }
</script>

<style>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }

  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }

  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }

  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
