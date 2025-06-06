import axios from "axios";

export const getJobs = async () => {
  try {
    const response = await axios.get("http://localhost:8080/api/jobs");
    return response.data;
  } catch (error) {
    console.error("Error fetching jobs:", error);
    throw error;
  }
};
