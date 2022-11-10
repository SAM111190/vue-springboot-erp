<template>
  <div>
    <div class="title">
      <b>商品系统</b>
    </div>
    <div class="operation">
      <el-button type="primary" @click="handleAdd"><i class="el-icon-folder-add" style="margin-right: 5px"></i>新增</el-button>
    </div>
    <el-table
        :data="tableData"
        border
        stripe
        :header-cell-class-name="headerBg"
    >
      <el-table-column prop="id" label="id">
      </el-table-column>
      <el-table-column prop="name" label="名称">
      </el-table-column>
      <el-table-column prop="fac" label="上架公司">
      </el-table-column>
      <el-table-column prop="price" label="价格">
      </el-table-column>
      <el-table-column prop="sold" label="销量">
      </el-table-column>
      <el-table-column prop="playernum" label="游玩人数">
      </el-table-column>
      <el-table-column prop="gametype" label="游戏类型">
      </el-table-column>
      <el-table-column prop="date" label="发行时间">
      </el-table-column>
      <el-table-column prop="producer" label="发行商">
      </el-table-column>
      <el-table-column label="操作" width="180" fixed="right">
        <template slot-scope="scope">
          <el-button type="info" @click="handleEdit(scope.row)"><i class="el-icon-edit"></i>编辑</el-button>
          <el-popconfirm
              title="确定删除吗？"
              style="margin-left: 10px"
              @confirm="handleDelete(scope.row.id)"
          >
            <el-button type="danger" slot="reference"><i class="el-icon-delete"></i>删除</el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
              <div class="pagination">
                <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    background
                    :current-page="pageNum"
                    :page-sizes="[2,5,10]"
                    :page-size="pageSize"
                    layout="total, prev, pager, next"
                    :total="total"
                >
                </el-pagination>
              </div>

    <!--          新增弹窗-->
    <el-dialog
        title="新增"
        width="60%"
        :visible.sync="dialogFormVisible"
    >
      <el-form :model="form" label-width="150px">
        <el-form-item label="名称">
          <el-input v-model="form.name" style="padding-right: 80px"></el-input>
        </el-form-item>
        <el-form-item label="缩略图地址">
          <el-input v-model="form.imgUrl" style="padding-right: 80px"></el-input>
        </el-form-item>
        <el-form-item label="上架公司">
          <el-input v-model="form.fac" style="padding-right: 80px"></el-input>
        </el-form-item>
        <el-form-item label="商品单位">
          <el-input v-model="form.unit" style="padding-right: 80px"></el-input>
        </el-form-item>
        <el-form-item label="商品价格">
          <el-input v-model="form.price" style="padding-right: 80px"></el-input>
        </el-form-item>
        <el-form-item label="商品介绍">
          <el-input  type="textarea" v-model="form.info" style="padding-right: 80px"></el-input>
        </el-form-item>
        <el-form-item label="游戏类型编号">
          <el-input v-model="form.type" style="padding-right: 80px"></el-input>
        </el-form-item>
        <el-form-item label="游戏销量">
          <el-input v-model="form.sold" style="padding-right: 80px"></el-input>
        </el-form-item>
        <el-form-item label="介绍页背景">
          <el-input v-model="form.backgroundcolor" style="padding-right: 80px"></el-input>
        </el-form-item>
        <el-form-item label="游戏支持平台">
          <el-input v-model="form.platform" style="padding-right: 80px"></el-input>
        </el-form-item>
        <el-form-item label="游玩人数">
          <el-input v-model="form.playernum" style="padding-right: 80px"></el-input>
        </el-form-item>
        <el-form-item label="游戏类型描述">
          <el-input v-model="form.gametype" style="padding-right: 80px"></el-input>
        </el-form-item>
        <el-form-item label="支持语言">
          <el-input v-model="form.language" style="padding-right: 80px"></el-input>
        </el-form-item>
        <el-form-item label="发行时间">
          <el-input v-model="form.date" style="padding-right: 80px"></el-input>
        </el-form-item>
        <el-form-item label="发行商">
          <el-input v-model="form.producer" style="padding-right: 80px"></el-input>
        </el-form-item>
        <el-form-item label="详情图地址">
          <el-input v-model="form.imgDetail" style="padding-right: 80px"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import request from "@/utils/request";
export default {
  name: "goods",
  data() {
    return {
      form: {},
      dialogFormVisible:false,
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 10,
      collapseBtnClass:'el-icon-s-fold',
      isCollapsed:false,
      sideWidth:200,
      logoTextShow:true,
      multipleSelection:[],
      headerBg:'headerBg',
    }
  },
  created() {
    //请求分页查询的数据
    this.load();
  },
  methods: {
    load() {//请求分页数据
      request.get("/goods/page",{
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
        }
      }).then(res => {
        this.tableData = res.data;
        this.total = res.total;
      })
    },
    save() {
      this.request.post("/goods",this.form).then(res => {
        if(res) {
          this.$message.success("添加成功")
          this.dialogFormVisible = false
          this.load()
        }
        else {
          this.$message.error("添加失败")
        }
      })
    },
    handleDelete(id) {
      this.request.delete("/goods/" + id).then(res => {
        if(res) {
          this.$message.success("删除成功")
          this.load()
        }
        else {
          this.$message.error("删除失败")
        }
      })
    },
    handleAdd() {
      this.dialogFormVisible = true;
      this.form = {};
    },
    handleEdit(row) {
      this.form = row;
      this.dialogFormVisible = true;
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize;
      this.load();
    },
    handleCurrentChange(pageNum) {
      this.pageNum = pageNum;
      this.load();
    },
  }
}
</script>

<style scoped>
.title {
  font-size: 20px;
}
.operation {
  margin: 10px 0 10px 0;
}
.pagination {
  padding: 10px 0;
}
.headerBg {
  background: #333333!important;
}
</style>
