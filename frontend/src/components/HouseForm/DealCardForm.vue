<script setup>
import { defineProps } from "vue";
const props = defineProps({
  deal: Object,
});

console.log(props.deal);
</script>

<template>
  <div class="dealCardComponent">
    <a-row>
      <a-col> 거래일 : {{ props.deal.dealYear }} </a-col>
    </a-row>
    <a-row>
      <a-col> 거래금액 : {{ props.deal.dealAmount }} </a-col>
    </a-row>
    <a-row>
      <a-col> 건축년도 : {{ props.deal.buildYear }} </a-col>
    </a-row>
    <a-row>
      <a-col> 전용면적 : {{ props.deal.area }} </a-col>
    </a-row>
    <a-row>
      <a-col> 층 : {{ props.deal.floor }} </a-col>
    </a-row>
  </div>
</template>

<style scoped>
.dealCardComponent {
  width: 400px;

  margin-bottom: 10px;

  border: 1px solid black;
  border-radius: 5px;
}
</style>
