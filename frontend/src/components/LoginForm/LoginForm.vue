<script setup>
import LoginLeftForm from "./LoginLeftForm.vue";
import LoginRightForm from "./LoginRightForm.vue";
</script>

<template>
  <a-row>
    <LoginLeftForm />
    <LoginRightForm />
  </a-row>
  <!-- <div class="whole_frame"></div> -->
</template>

<style scoped>
.whole_frame {
  position: absolute;
  top: 0;
  left: 0;
  z-index: -1;

  background-color: rgba(255, 255, 255, 1);
  width: 1600px;
  height: 1024px;

  background-image: url("@/assets/img/home-mitchuddai background img.jpg");
  background-size: 1600px 1024px;
}
/* .left {
  width: 453px;
  height: 575px;
} */
</style>
