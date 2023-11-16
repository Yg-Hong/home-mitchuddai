<script setup>
const props = defineProps({
  house: Object,
});

// console.log(props.house);
</script>

<template>
  <div class="houseComponent">
    <a-row justify="start">
      <a-col>{{ house.apartmentName }}</a-col>
    </a-row>
    <a-row justify="start">
      <a-col>
        {{ house.sidoName }} {{ house.gugunNAme }} {{ house.dongName }} {{ house.roadName }}
      </a-col>
    </a-row>
    <a-row justify="start">
      <a-col> 면적 : {{ house.area }} </a-col>
    </a-row>
    <a-row>
      <a-col> 건축년도 : {{ house.buildYear }} </a-col>
    </a-row>
    <a-row>
      <a-col> 마지막 거래 년도 : {{ house.latestDealYear }} </a-col>
    </a-row>
  </div>
</template>

<style scoped>
.houseComponent {
  width: 400px;

  margin-bottom: 10px;

  border: 1px solid black;
  border-radius: 5px;
}
</style>
