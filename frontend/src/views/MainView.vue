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
</template>

<style scoped>
.contents {
  width: 100%;
  padding-top: 75px;
}
</style>
