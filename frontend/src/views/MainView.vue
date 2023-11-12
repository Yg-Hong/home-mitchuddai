<script setup>
import WithoutLoginNavForm from "../components/nav/WithoutLoginNavForm.vue";
import { RouterView } from "vue-router";
</script>

<template>
  <WithoutLoginNavForm />

  <!-- 메인 폼 -->
  <router-view />

  <!-- 푸터 -->
  <FotterForm />
</template>

<style scoped>
.loginForm {
  width: 1280px;
}
</style>
