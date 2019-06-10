package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
 * 1. Make the JobCandidate class implement Comparable.  
 * 2. Add a JobCandadate instance that represents yourself, and use compareTo() to see who should be given the job.
 * 
 */

import java.util.List;

public class JobCandidate implements Comparable<JobCandidate> {

	private String name;
	private List<String> personalityTraits;
	private int hoursSpentCoding;
	private String teacherName;
	private int salaryRequired;

	public JobCandidate(List<String> personalityTraits, int hoursSpentCoding, String teacherName, int salaryRequired,
			String name) {
		super();
		this.name = name;
		this.personalityTraits = personalityTraits;
		this.hoursSpentCoding = hoursSpentCoding;
		this.teacherName = teacherName;
		this.salaryRequired = salaryRequired;
	}

	public static void main(String[] args) {
		JobCandidate june = new JobCandidate(Arrays.asList(new String[] { "adaptable", "scatty", "curious" }), 650,
				"Vinny Wade", 1200000, "June Clark");
		JobCandidate milan = new JobCandidate(Arrays.asList(new String[] { "adaptable", "scatty", "curious" }),
				june.hoursSpentCoding/3, "June Clark", june.salaryRequired*2, "Milan Lukic");

		ArrayList<JobCandidate> candidatesList = new ArrayList<JobCandidate>();
		candidatesList.add(june);
		candidatesList.add(milan);

		System.out.println("Job should be given to : " + candidatesList.get(0).name);
	}

	@Override
	public int compareTo(JobCandidate obj) {

		int compare = this.personalityTraits.size() - obj.personalityTraits.size();
		compare += this.hoursSpentCoding - obj.hoursSpentCoding;
		compare += this.salaryRequired - obj.salaryRequired;
		return compare;
	}

}
