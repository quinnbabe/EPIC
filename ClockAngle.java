/**
 * We are given a specific time(like 02:23), we need to get the angle between
 * hour and minute(less than 180)
 */
public class ClockAngle {
	public static void calculateAngle(String time){
		String[] list = time.split(":");
		int hour = Integer.parseInt(list[0]);
		int minute = Integer.parseInt(list[1]);
		double angle = getAngle(hour, minute);
		
		System.out.println("angle2:"+angle);

	}
	private static double getAngle(int hour, int minute){
		//12->360    0.5 per minute, 30 per hour
		//60->360    6 per minute
		double rH = 0.5*minute + 30*hour;
		double rM = 6*minute;
		double difference = Math.abs(rH-rM)%180;
		return difference;
	}

	public static void main(String[] args) {
		calculateAngle("02:33");
	}

}
