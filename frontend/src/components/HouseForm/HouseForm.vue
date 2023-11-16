<script setup>
import HouseListForm from "@/components/HouseForm/HouseListForm.vue";
import KakaoMapForm from "./KakaoMapForm.vue";
import { RouterView } from "vue-router";

import { ref } from "vue";

const latAndLngList = ref([]);

const changeLatAndLngList = (newList) => {
  console.log(newList);
  latAndLngList.value = newList;
};
</script>

<template>
  <a-row justify="center">
    <a-col :span="8" class="LeftForm">
      <!-- <HouseListForm @changeLatAndLngList="changeLatAndLngList" /> -->
      <RouterView />
    </a-col>
    <a-col :span="16">
      <KakaoMapForm :latAndLngList="latAndLngList" />
    </a-col>
  </a-row>
</template>

<style scoped>
.LeftForm {
  padding-right: 30px;

  border-right: 1px solid black;
}
</style>
