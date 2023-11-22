<script setup>
import HouseDetailCardForm from "@/components/HouseForm/HouseDetailCardForm.vue";
import { ref, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
import { useHouseStore } from "@/stores/HouseStore.js";
import { storeToRefs } from "pinia";

const houseStore = useHouseStore();
const { houseList, house } = storeToRefs(houseStore);
console.log(houseList);

onMounted(() => {
  if (houseList.value.length == 0) {
    console.log("houseList is empty");
    houseStore.setHouseList1(route.params.dongCode);
  }

  console.log(houseStore.getHouseList);
  console.log("mounted");
});

const router = useRouter();
const route = useRoute();

// watch(houseList, () => {
//   console.log("houseList changed");
//   let newArray = [];

//   houseList.value.forEach((house) => {
//     newArray.push({
//       aptCode: house.aptCode,
//       title: house.apartmentName,
//       latlng: [house.lat, house.lng],
//     });
//   });

//   console.log(newArray);

//   emit("changeLatAndLngList", newArray);
// });

const onClickHouseDetailInfo = (aptCode) => {
  let dongCode = route.params.dongCode;
  router.push(`/house/${dongCode}/${aptCode}`);

  for (let i = 0; i < houseList.value.length; i++) {
    if (houseList.value[i].aptCode == aptCode) {
      house.value = houseList.value[i];
    }
  }
};

const current = ref(2);
</script>

<template>
  <div class="HouseListForm">
    <a-row justify="center" class="contenthHeader NexonGothicMedium">
      <span>실거래 목록</span>
    </a-row>
    <template v-for="(house, index) in houseList" :key="index">
      <a-row justify="center">
        <HouseDetailCardForm
          v-bind:house="house"
          @click="onClickHouseDetailInfo(house.aptCode)"
        />
        <template>
          <a-pagination v-model:current="current" simple :total="10" />
        </template>
      </a-row>
    </template>
  </div>
</template>

<style scoped>
.HouseListForm {
  height: 850px;
}

.contenthHeader {
  padding-top: 10px;

  font-size: 20px;
  font-weight: bold;
  margin-bottom: 10px;
}
</style>
