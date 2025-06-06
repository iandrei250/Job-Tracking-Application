import { useEffect } from "react";
import { getJobs } from "../utils/api/api";

export const HomePage = () => {
  const jobs = getJobs();

  useEffect(() => {
    console.log(
      "Jobs fetched:",
      jobs.then((data) => data)
    );
  }, [jobs]);

  return <></>;
};
