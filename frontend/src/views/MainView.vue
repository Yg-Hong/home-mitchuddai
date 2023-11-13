<script setup>
import WithoutLoginNavForm from "../components/nav/WithoutLoginNavForm.vue";
import { RouterView } from "vue-router";
</script>

<template>
  <WithoutLoginNavForm />

  <!-- 메인 폼 -->
  <div class="contents">
    <router-view />
  </div>

  <!-- 푸터 -->
  <FotterForm />
</template>

<style scoped>
.contents {
  padding-top: 75px;
}
</style>
