import axios from "axios";
import { toast } from "react-toastify";

const CMS_API_URL = import.meta.env.REACT_APP_CMS_URL ? import.meta.env.REACT_APP_CMS_URL : "http://localhost:1337";

export const fetchCMSContent = async () => {
  try {
    const response = await axios.get(`${CMS_API_URL}/home`);
    return response.data;
  } catch (error) {
    toast.error("Failed to load CMS content");
    throw error;
  }
};