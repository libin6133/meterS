<template>
  <span v-if="config">
    <div v-for="(item, index) in config" :key="index">
      <el-checkbox v-model="item.enable" @change="click(item)">{{ item.name }}
        <test-plan-report-config :config="item.children" :father="config[index]"/>
      </el-checkbox>
    </div>
  </span>
</template>

<script>
export default {
  name: "TestPlanReportConfig",
  props: ['config', 'father'],
  methods: {
    click(item) {
      if (item.children) {
        for (const childName in item.children) {
          let child = item.children[childName];
          if (child) {
            child.enable = item.enable;
            this.click(child);
          }
        }
      }

      if (item.enable && this.father) {
        this.father.enable = true;
      }
    }
  }
}
</script>

<style scoped>
.el-checkbox {
  margin: 10px;
}

.el-checkbox >>> .el-checkbox__input {
  vertical-align: top;
}
</style>
