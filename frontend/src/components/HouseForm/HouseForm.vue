<script setup>
import HouseListForm from "@/components/HouseForm/HouseListForm.vue";
import KakaoMapForm from "./KakaoMapForm.vue";
import { RouterView } from "vue-router";

import { ref } from "vue";

const MarkerList = ref([]);

const changeLatAndLngList = (newList) => {
  console.log("HouseForm: " + newList.value);
  MarkerList.value = newList;
};
</script>

<template>
  <a-row justify="center">
    <a-col :span="8" class="LeftForm">
      <!-- <HouseListForm @changeLatAndLngList="changeLatAndLngList" /> -->
      <RouterView @changeLatAndLngList="changeLatAndLngList" />
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
