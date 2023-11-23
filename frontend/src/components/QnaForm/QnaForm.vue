<script setup>
import { RouterView } from "vue-router";
</script>

<template>
  <a-row justify="center" class="QnaBoardTitle"> Qna게시판임요 </a-row>

  <RouterView />
</template>

<style scoped>
.QnaBoardTitle {
  width: 80%;
  padding-top: 110px;
}
</style>
