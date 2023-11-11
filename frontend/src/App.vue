<script setup>
import { RouterView } from "vue-router";
</script>

<template>
  <RouterView />
</template>

<style scoped>
.v-application {
  font-family: "NexonGothic", sans-serif !important;
}

@font-face {
  font-family: "NexonGothic";
  src: url("@/assests/fonts/NEXON Lv2 Gothic.ttf") format("truetype");
  font-weight: 400;
}

@font-face {
  font-family: "NexonGothic";
  src: url("@/assests/fonts/NEXON Lv2 Gothic Bold.ttf") format("truetype");
  font-weight: 700;
}

@font-face {
  font-family: "NexonGothic";
  src: url("@/assests/fonts/NEXON Lv2 Gothic Medium.ttf") format("truetype");
  font-weight: 500;
}

@font-face {
  font-family: "NexonGothic";
  src: url("@/assests/fonts/NEXON Lv2 Gothic Light.ttf") format("truetype");
  font-weight: 300;
}
</style>
