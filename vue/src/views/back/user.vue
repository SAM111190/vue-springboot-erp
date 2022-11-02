<template>
  <div>
    <div class="title">
      <b>用户系统</b>
    </div>
    <div class="operation">
      <el-button type="primary" @click="handleAdd"><i class="el-icon-folder-add"></i>添加</el-button>
      <el-button type="success"><i class="el-icon-position"></i>计算</el-button>
    </div>
    <el-table
        height="75vh"
        :data="tableData"
        border
        stripe
        :header-cell-class-name="headerBg"
    >
      <el-table-column prop="target" label="id">
      </el-table-column>
      <el-table-column prop="number" label="用户名">
      </el-table-column>
      <el-table-column prop="date" label="密码">
      </el-table-column>
      <el-table-column prop="date" label="性别">
      </el-table-column>
      <el-table-column prop="date" label="生日">
      </el-table-column>
      <el-table-column label="操作" width="180">
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
    <!--          <div class="pagination">-->
    <!--            <el-pagination-->
    <!--                @size-change="handleSizeChange"-->
    <!--                @current-change="handleCurrentChange"-->
    <!--                background-->
    <!--                :current-page="pageNum"-->
    <!--                :page-sizes="[2,5,10]"-->
    <!--                :page-size="pageSize"-->
    <!--                layout="total, prev, pager, next"-->
    <!--                :total="total"-->
    <!--            >-->
    <!--            </el-pagination>-->
    <!--          </div>-->

    <!--          新增弹窗-->
    <el-dialog
        title="添加"
        width="60%"
        :visible.sync="dialogFormVisible"
    >
      <el-form :model="form" :inline="true">
        <el-form-item label="目标产品" >
          <el-select v-model="form.target" placeholder="请选择产品">
            <el-option label="眼镜" value="眼镜"></el-option>
            <el-option label="镜片" value="镜片"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="生产数量">
          <el-input v-model="form.number" placeholder="请输入需要的数量"></el-input>
        </el-form-item>
        <el-form-item label="交付日期">
          <el-date-picker
              v-model="form.date"
              type="date"
              placeholder="选择日期"
              format="yyyy-MM-dd"
              value-format="yyyy-MM-dd">
          </el-date-picker>
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
export default {
  name: "Mrp",
  data() {
    return {
      form: {},
      dialogFormVisible:false,
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 5,
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
      this.request.get("/mrp/page",{
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
      this.request.post("/mrp",this.form).then(res => {
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
      this.request.delete("/mrp/" + id).then(res => {
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
