// src/api/cmsApi.js
import axios from "axios";
import { toast } from "react-toastify";

const CMS_URL = "http://localhost:1337";

export const fetchCMSContent = async () => {
  try {
    const response = await axios.get(`${CMS_URL}/home`);
    return response.data;
  } catch (error) {
    toast.error("Failed to load CMS content");
    throw error;
  }
};