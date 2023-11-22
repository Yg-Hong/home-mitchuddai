<script setup>
import KakaoMapForm from "./KakaoMapForm.vue";
import { RouterView } from "vue-router";

import { ref } from "vue";

const houseMarkerList = ref([]);

const changeLatAndLngList = (newList) => {
  console.log("HouseForm: " + newList);
  houseMarkerList.value = newList;
  console.log(houseMarkerList.value);
};

const updateHouseMarkerList = (newList) => {
  console.log("HouseForm: " + newList);
  houseMarkerList.value = newList;
  console.log(houseMarkerList.value);
};
</script>

<template>
  <a-row justify="start">
    <a-col :span="8" class="LeftForm">
      <!-- <HouseListForm @changeLatAndLngList="changeLatAndLngList" /> -->
      <RouterView @changeLatAndLngList="changeLatAndLngList" />
    </a-col>
    <a-col :span="16">
      <KakaoMapForm
        :houseMarkerList="houseMarkerList"
        @updateHouseMarkerList="updateHouseMarkerList"
      />
    </a-col>
  </a-row>
</template>

<style scoped>
.LeftForm {
  padding-right: 30px;
  height: 850px;

  border-right: 1px solid black;
}
</style>
