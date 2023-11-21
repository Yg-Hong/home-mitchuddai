import { defineStore } from "pinia";
import { ref, computed } from "vue";
import HouseAPI from "@/api/HouseAPI.js";

export const useHouseDetailInfoStore = defineStore("houseDetailInfo", () => {
  const houseDetailInfo = ref({});
  const isLoading = ref(false);

  const fetchHouseDetailInfo = async (dongCode, aptCode) => {
    isLoading.value = true;

    // const getHouseDetail = (dongCode, aptCode, success, fail) => {
    //     HouseAPI.get(`house/${dongCode}/${aptCode}`).then(success).catch(fail);
    //   };
    try {
      await HouseAPI.getHouseDetailInfo(
        dongCode,
        aptCode,
        ({ data }) => {
          houseDetailInfo.value = data;
        },
        () => {
          console.log("주택 정보 가져오기에 실패했습니다.");
        }
      );
    } catch (error) {
      console.log("API 호출에 실패했습니다.");
    } finally {
      isLoading.value = false;
    }
  };

  const pData = computed(() => {
    houseDetailInfo.value.map((d) => ({
      aptCode: d.aptCode,
      buildYear: d.buildYear,
      roadName: d.roadName,
      apartmentName: d.apartmentName,
      jibun: d.jibun,
      lng: d.lng,
      lat: d.lat,
      sidoName: d.sidoName,
      gugunName: d.gugunName,
      dongName: d.dongName,
      houseDeals: d.houseDeals,
    }));
  });

  return { isLoading, pData, fetchHouseDetailInfo };
});
