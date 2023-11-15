<script setup>
import HouseListForm from "@/components/HouseForm/HouseListForm.vue";
import KakaoMapForm from "./KakaoMapForm.vue";
</script>

<template>
  <a-row justify="center">
    <a-col :span="8">
      <HouseListForm />
    </a-col>
    <a-col :span="16">
      <KakaoMapForm />
    </a-col>
  </a-row>
  <div>ad</div>
</template>

<style scoped></style>
