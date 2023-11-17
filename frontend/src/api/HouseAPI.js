import { localAxios } from "@/utils/http-commons";

const HouseAPI = localAxios();

const getHouseList = (dongCode, success, fail) => {
  HouseAPI.get(`house/${dongCode}`).then(success).catch(fail);
};

const getHouseDetail = (dongCode, aptCode, success, fail) => {
  HouseAPI.get(`house/${dongCode}/${aptCode}`).then(success).catch(fail);
};

export default { getHouseList, getHouseDetail };
