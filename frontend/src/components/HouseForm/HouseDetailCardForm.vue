<script setup>
const props = defineProps({
  house: Object,
});

console.log(props.house);
</script>

<template>
  <div class="houseComponent">
    <a-row justify="start" class="contentRow">
      <a-col class="NexonGothicMedium FontMS">{{ house.apartmentName }}</a-col>
    </a-row>
    <a-row justify="start" class="contentRow">
      <a-col class="NexonGothicLight FontS">
        {{ house.sidoName }} {{ house.gugunNAme }} {{ house.dongName }}
        {{ house.roadName }}
      </a-col>
    </a-row>
    <a-row class="contentRow">
      <a-col class="NexonGothicLight FontS">
        건축년도 : {{ house.buildYear }} 년
      </a-col>
    </a-row>
  </div>
</template>

<style scoped>
.houseComponent {
  width: 400px;

  margin-bottom: 10px;

  border-left: 7px solid rgb(213, 231, 53);
  border-radius: 5px;
}

.contentRow {
  padding-bottom: 5px;

  margin-left: 5px;
}
</style>
