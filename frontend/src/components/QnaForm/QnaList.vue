<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";

const qnaList = ref([]);

const router = useRouter();

for (let i = 0; i < 100; i++) {
  qnaList.value.push({
    no: i,
    name: `홍윤기 ${i}`,
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
    title: "작성자",
    dataIndex: "name",
    width: "15%",
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
    onClick: (event) => {
      console.log("click row", record);
      router.push(`/qna/${record.no}`);
    },
  };
};
</script>

<template>
  <a-table :customRow="customRow" :columns="columns" :data-source="qnaList">
    <template #bodyCell="{ column, text }">
      <template v-if="column.dataIndex === 'title'">
        <a>{{ text }}</a>
      </template>
    </template>
  </a-table>

  <a-row justify="end">
    <a-button class="margin_top writeBtn" @click="router.push('/qna/write')">글쓰기</a-button>
  </a-row>
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
