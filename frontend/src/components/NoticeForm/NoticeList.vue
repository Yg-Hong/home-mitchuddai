<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";

const noticeList = ref([]);

const router = useRouter();

for (let i = 0; i < 100; i++) {
  noticeList.value.push({
    no: i,
    title: "Hello world",
    date: "2021-10-01",
  });
}

const columns = [
  {
    title: "no",
    dataIndex: "no",
    width: "10%",
  },
  {
    title: "제목",
    dataIndex: "title",
    width: "55%",
  },
  {
    title: "작성일자",
    dataIndex: "date",
  },
];

const customRow = (record) => {
  return {
    onClick: () => {
      console.log("click row", record);
      router.push(`/notice/${record.no}`);
    },
  };
};
</script>

<template>
  <a-table :customRow="customRow" :columns="columns" :data-source="noticeList">
    <template #bodyCell="{ column, text }">
      <template v-if="column.dataIndex === 'title'">
        <a>{{ text }}</a>
      </template>
    </template>
  </a-table>
</template>

<style scoped>
.writeBtn {
  background-color: #002266;
  color: white;
}

.writeBtn:hover {
  background-color: #00387e;
  color: white;
}
</style>
