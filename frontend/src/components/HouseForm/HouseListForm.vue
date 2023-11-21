<script setup>
import HouseDetailCardForm from "@/components/HouseForm/HouseDetailCardForm.vue";
import { ref, defineEmits, watch } from "vue";
import { useRouter, useRoute } from "vue-router";
import HouseAPI from "../../api/HouseAPI";

const emit = defineEmits(["changeLatAndLngList"]);
const router = useRouter();
const route = useRoute();

const houseList = ref([
  {
    aptCode: 11110000000042,
    buildYear: "2000",
    roadName: "자하문로 33길",
    readNameBonbun: 43,
    dongCode: 1111010100,
    apartmentName: "청운현대",
    lng: 126.970672,
    lat: 37.586305,
    area: 84.82,
    sidoName: "서울특별시",
    gugunName: "종로구",
    dongName: "청운동",
  },
  {
    aptCode: 11110000000043,
    buildYear: "2110",
    roadName: "자하문로",
    readNameBonbun: 433,
    dongCode: 1111010100,
    apartmentName: "청운현대",
    lng: 126.970672,
    lat: 37.586305,
    area: 84.82,
    sidoName: "서울특별시",
    gugunName: "종로구",
    dongName: "청운동",
  },
]);

watch(houseList, () => {
  console.log("houseList changed");
  let newArray = [];

  houseList.value.forEach((house) => {
    newArray.push({
      title: house.apartmentName,
      latlng: [house.lat, house.lng],
    });
  });

  console.log(newArray);

  emit("changeLatAndLngList", newArray);
});

const onClickHouseDetailInfo = (aptCode) => {
  let dongCode = route.params.dongCode;
  router.push(`/house/${dongCode}/${aptCode}`);
};

const getHouseList = () => {
  HouseAPI.getHouseList(
    route.params.dongCode,
    ({ data }) => {
      houseList.value = data;
    },
    () => {
      console.log("실거래 목록 조회에 실패하였습니다.");
    }
  );
};

getHouseList();
</script>

<template>
  <div class="HouseListForm">
    <a-row justify="centr">
      <span>실거래 목록</span>
    </a-row>
    <template v-for="(house, index) in houseList" :key="index">
      <a-row justify="center">
        <HouseDetailCardForm
          v-bind:house="house"
          @click="onClickHouseDetailInfo(house.aptCode)"
        />
      </a-row>
    </template>
  </div>
</template>

<style scoped>
.HouseListForm {
  height: 850px;
}
</style>
