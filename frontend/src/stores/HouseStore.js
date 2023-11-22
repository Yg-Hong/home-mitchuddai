import HouseAPI from "@/api/houseAPI.js";
import LocationAPI from "@/api/locationAPI.js";

import { defineStore } from "pinia";
import { ref, computed } from "vue";

export const useHouseStore = defineStore("houseStore", () => {
  const sidos = ref([{ value: null, text: "선택하세요" }]);
  const guguns = ref([{ value: null, text: "선택하세요" }]);
  const dongs = ref([{ value: null, text: "선택하세요" }]);
  const houses = ref([]);
  const house = ref(null);
  const houseinfos = ref([]);
  const region1depthName = ref(null);
  const region2depthName = ref(null);
  const open = ref(false);
  const addressName = ref(null);
  const option = ref(0);

  const distance = ref([]);

  //getter
  const getSidos = computed(() => {
    return sidos.value;
  });
  const getGuguns = computed(() => {
    return guguns.value;
  });
  const getDongs = computed(() => {
    return dongs.value;
  });
  const getHouses = computed(() => {
    return houses.value;
  });
  const getHouse = computed(() => {
    return house.value;
  });
  const getHouseinfos = computed(() => {
    return houseinfos.value;
  });
  const getRegion1depthName = computed(() => {
    return region1depthName.value;
  });
  const getRegion2depthName = computed(() => {
    return region2depthName.value;
  });
  const getOpen = computed(() => {
    return open.value;
  });
  const getAddressName = computed(() => {
    return addressName.value;
  });
  const getOption = computed(() => {
    return option.value;
  });
  const getDistance = computed(() => distance.value);

  //action
  const clearSidoList = () => {
    this.sidos.value = [{ value: null, text: "선택하세요" }];
  };
  const clearGugunList = () => {
    this.guguns.value = [{ value: null, text: "선택하세요" }];
  };
  const clearDongList = () => {
    this.dongs.value = [{ value: null, text: "선택하세요" }];
  };
  const clearAptList = () => {
    this.houses.value = [];
    this.house.value = null;
  };
  const clearRegion1depth = () => {
    this.region1depthName.value = null;
  };
  const clearRegion2depth = () => {
    this.region2depthName.value = null;
  };
  const clearOpen = () => {
    this.open.value = false;
  };
  const clearDistance = () => {
    distance.value = [];
  };
  const setSidoList = (sidos) => {
    sidos.forEach((sido) => {
      this.sidos.value.push({ value: sido.sidoCode, text: sido.sidoName });
    });
  };
  const setGugunList = (guguns) => {
    guguns.forEach((gugun) => {
      this.guguns.value.push({ value: gugun.gugunCode, text: gugun.gugunName });
    });
  };
  const setDongList = (dongs) => {
    dongs.forEach((dong) => {
      this.dongs.value.push({ value: dong.dongCode, text: dong.dongName });
    });
  };
  const setHouseInfoList = (houseinfos) => {
    houseinfos.forEach((houseinfo) => {
      this.houseinfos.value.push(houseinfo.aptName);
    });
  };
  const setHouseList = (houses) => {
    this.houses.value = houses;
  };
  const setDetailHouse = (house) => {
    this.house.value = house;
  };
  const setRegion1depth = (region1depthName) => {
    this.region1depthName.value = region1depthName;
  };
  const setRegion2depth = (region2depthName) => {
    this.region2depthName.value = region2depthName;
  };
  const setAddressName = (addressName) => {
    this.addressName.value = addressName;
  };
  const setDetailClose = () => {
    this.open.value = false;
  };
  const setDetailOpen = () => {
    this.open.value = true;
  };
  const setSelectOpt = (option) => {
    this.option.value = option;
  };
  const setDistance = (item) => {
    distance.value.push(item);
  };

  // fetch
  // const HouseAPI = localAxios();

  // const getHouseList = (dongCode, success, fail) => {
  //   HouseAPI.get(`house/${dongCode}`).then(success).catch(fail);
  // };

  // const getHouseDetail = (dongCode, aptCode, success, fail) => {
  //   HouseAPI.get(`house/${dongCode}/${aptCode}`).then(success).catch(fail);
  // };

  // export default { getHouseList, getHouseDetail };

  const fetchHouseList = async (dongCode) => {
    await HouseAPI.getHouseList(
      dongCode,
      ({ data }) => {
        console.log("success");
        setHouseInfoList(data);
      },
      () => {
        console.log("fail");
      }
    );
  };

  const fetchSido = async () => {
    await LocationAPI.getSido(
      ({ data }) => {
        console.log("success");
        setSidoList(data);
      },
      () => {
        console.log("fail");
      }
    );
  };

  const fetchGugun = async (sidoCode) => {
    await LocationAPI.getGugun(
      sidoCode,
      ({ data }) => {
        console.log("success");
        setGugunList(data);
      },
      () => {
        console.log("fail");
      }
    );
  };

  const fetchDong = async (sidoCode, gugunCode) => {
    await LocationAPI.getDong(
      sidoCode,
      gugunCode,
      ({ data }) => {
        console.log("success");
        setDongList(data);
      },
      () => {
        console.log("fail");
      }
    );
  };

  return { setDistance, getDistance, clearDistance };
});
