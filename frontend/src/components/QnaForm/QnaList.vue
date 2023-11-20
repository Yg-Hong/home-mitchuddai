<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import QnaAPI from "@/api/QnaAPI.js";

const qnaList = ref([]);
const totalPage = ref(0);

const router = useRouter();

// for (let i = 0; i < 100; i++) {
//   QnaAPI.writeQna(
//     {
//       title: `홍윤기 ${i}`,
//       content: "Hello world",
//       authorId: "admin",
//     },
//     (response) => {
//       console.log(response);
//     },
//     (error) => {
//       console.log(error);
//     }
//   );
// }

const columns = [
  {
    title: "no",
    dataIndex: "no",
    width: "10%",
  },
  {
    title: "작성자",
    dataIndex: "authorId",
    width: "15%",
  },
  {
    title: "제목",
    dataIndex: "title",
    width: "55%",
  },
  {
    title: "작성일자",
    dataIndex: "createAt",
  },
];

const getQnaList = (pageInfo) => {
  QnaAPI.getQnaList(
    pageInfo,
    ({ data }) => {
      console.log(data);

      qnaList.value = data.result;
      // totalPage.value = data.totalPage;
      // qnaList.value = data.result;
    },
    (error) => {
      console.log(error);
    }
  );
};

const customRow = (record) => {
  return {
    onClick: () => {
      console.log("click row", record);
      router.push(`/qna/${record.no}`);
    },
  };
};

const onChangepageInfo = (page, size) => {
  console.log("pageInfo changed");

  const pageInfo = {
    page,
    size,
  };

  console.log(pageInfo);

  getQnaList(pageInfo);
};

getQnaList();
</script>

<template>
  <a-table :customRow="customRow" :columns="columns" :data-source="qnaList">
    <template #bodyCell="{ column, text }">
      <template v-if="column.dataIndex === 'title'">
        <a>{{ text }}</a>
      </template>
    </template>
  </a-table>
  <a-pagination v-model:current="current" :total="100" show-less-items @change="onChangepageInfo" />

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
