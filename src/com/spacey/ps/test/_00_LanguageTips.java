package com.spacey.ps.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * This class is designed to help developers understand some of the lesser known
 * facts/tweaks in java
 * 
 * @author Spacey4uq
 *
 */
public class _00_LanguageTips {

	public static void main(String[] args) {
		intToStringConversion();
		intArrToList();
		arrayIsAnObject();
		childClassAlsoGetsInstanceOfParent();
		finallyBehaviorWhenTryReturns();
		stringBufferBehaviour();
		jsonArrayToStream();
		tryAndFinallyReturns();
		threadBehavior();
		regexMatching();
		streamUsecases();
		basicRestConnection_Get();
//		basicRestConnection_Post();
		retainLargestEntriesInHashMap();
	}

	private static void retainLargestEntriesInHashMap() {
		System.out.println("> retain largest entries in hashmap");
		int[] nums = {3,1,2,3,4,2,2,3};
		Map<Integer, Integer> numberToTheirOccurances = new HashMap<>();
		for(int n: nums) {
			numberToTheirOccurances.merge(n, 1, Integer::sum);
		}
		System.out.println("before: " + numberToTheirOccurances);
		// real logic begins
		int longest = numberToTheirOccurances.values().stream()
                .max(Integer::compare)
                .orElse(-1);
		numberToTheirOccurances = numberToTheirOccurances.entrySet().stream().filter(e -> e.getValue() == longest)
		.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
		
		System.out.println("longest: " + longest);
		System.out.println("after: " + numberToTheirOccurances);
		System.out.println("=========================================");
	}

	private static void streamUsecases() {
		// age > 30, sortBy name asc, output listOfIds
		class Employee {
			public int id;
			public int age;
			public String name;

			Employee(int id, int age, String name) {
				this.id = id;
				this.age = age;
				this.name = name;
			}

			String getName() {
				return name;
			}
		}
		System.out.println("> stream usecases");
		Comparator.comparing(Employee::getName);
		List<Employee> emps = Arrays.asList(new Employee(1, 40, "spacey"), new Employee(2, 35, "zack"));
		// list of employees who are older than 30, sorted by name desc, resulting their
		// ids.
		List<Integer> out = emps.stream().filter(e -> e.age > 30).sorted(Comparator.comparing(Employee::getName, (a, b) -> b.compareTo(a)))
				.map(e -> e.id).collect(Collectors.toList());
		System.out.println("Emps: " + out);
		System.out.println("=========================================");
	}

	private static void regexMatching() {
		System.out.println("> regex matching");
		Pattern pattern = Pattern.compile("lorry.+?walks");
		Matcher matcher = pattern.matcher("lorrywalks");
		while (matcher.find())
			System.out.println("1. regx: " + matcher.group());
		System.out.println("-----------------------------------------");
		System.out.println("Split operation:");
		pattern = Pattern.compile("and", Pattern.CASE_INSENSITIVE);
		String[] text = pattern.split("yes and no and duh");
		System.out.println(text[0] + ":" + text[1] + ":" + text[2]);
		System.out.println("-----------------------------------------");
		System.out.println("Lookahead operation:");
		// Refer:
		// https://www.ocpsoft.org/opensource/guide-to-regular-expressions-in-java-part-2/
		// Let抯 say we want to ensure that a password is made at least 8, but at most
		// 12 alphanumeric characters, and at least two numbers, in any position. We
		// will need to use a look-ahead expression in order to enforce a requirement of
		// two numbers. This look-ahead expression will require any number of characters
		// to be followed by a single digit, followed by any number of characters, and
		// another single digit. E.g.: �4�2, or �42, or 42�, or 4�2.
		List<String> input = new ArrayList<String>();
		input.add("password");
		input.add("p4ssword");
		input.add("p4ssw0rd");
		input.add("p45sword");

		for (String ssn : input) {
			if (ssn.matches("^(?=.*[0-9].*[0-9])[0-9a-zA-Z]{8,12}$")) {
				System.out.println(ssn + ": matches");
			} else {
				System.out.println(ssn + ": does not match");
			}
		}
		System.out.println("=========================================");
	}

	private static void threadBehavior() {
		System.out.println("> thread behavior");
		Thread runnable = getThreadFromLambda();
		System.out.println(runnable);
		System.out.println("thread run()");
		runnable.run();
		System.out.println("thread start()");
		runnable.start();
		System.out.println("=========================================");
	}

	private static Thread getThreadFromLambda() {
		return new Thread(() -> System.out.println("'this' context is for the outer class"), "main");
	}

	private static Thread getThreadFromAnonymousClass() {
		int i1 = 1; // cannot change because of this reason:
					// https://stackoverflow.com/questions/3910324/why-java-inner-classes-require-final-outer-instance-variables
		return new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("'this' context is for this anonymous class" + i1);
			}
		}, "main");
	}

	private static void tryAndFinallyReturns() {
		System.out.println("> try and finally returns");
		System.out.println(tryFinally());
		System.out.println("=========================================");
	}

	private static int tryFinally() {
		try {
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			return 3;
		}
	}

	private static void basicRestConnection_Post() {
		try {
			URL url = new URL("http://localhost:8080/RESTfulExample/json/product/post");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			String input = "{\"qty\":100,\"name\":\"iPad 4\"}";
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void basicRestConnection_Get() {
		System.out.println("> Basic REST connection (no libs)");
		int currentPage = 1, totalPages = Integer.MAX_VALUE;
		while (currentPage <= totalPages) {
			try {
				URL url = new URL("https://jsonmock.hackerrank.com/api/food_outlets?city=Denver&page=" + currentPage);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				JSONObject json = new JSONObject(reader.readLine());
				totalPages = json.getInt("total_pages");
				System.out.println("JSON response: " + json);
				conn.disconnect();
				currentPage++;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println("=========================================");
	}

	private static Stream<JSONObject> arrayToStream(JSONArray array) {
		return StreamSupport.stream(array.spliterator(), false).map(JSONObject.class::cast);
	}

	private static void jsonArrayToStream() {
		System.out.println("> json parsing example");
		int maxCostOf2Person = 10;
		String jsonString = "{\"page\":2,\"per_page\":10,\"total\":40,\"total_pages\":4,\"data\":[{\"city\":\"Denver\",\"name\":\"Hitch\",\"estimated_cost\":120,\"user_rating\":{\"average_rating\":4.8,\"votes\":3277},\"id\":311},{\"city\":\"Denver\",\"name\":\"The Fusion Kitchen\",\"estimated_cost\":160,\"user_rating\":{\"average_rating\":4.5,\"votes\":1463},\"id\":312},{\"city\":\"Denver\",\"name\":\"Social\",\"estimated_cost\":140,\"user_rating\":{\"average_rating\":4.6,\"votes\":7838},\"id\":313},{\"city\":\"Denver\",\"name\":\"Rude Lounge\",\"estimated_cost\":160,\"user_rating\":{\"average_rating\":4.1,\"votes\":4353},\"id\":314},{\"city\":\"Denver\",\"name\":\"Hi Lounge\",\"estimated_cost\":120,\"user_rating\":{\"average_rating\":4.7,\"votes\":1687},\"id\":315},{\"city\":\"Denver\",\"name\":\"BKC DIVE\",\"estimated_cost\":10,\"user_rating\":{\"average_rating\":4.6,\"votes\":5687},\"id\":316},{\"city\":\"Denver\",\"name\":\"Capital Social\",\"estimated_cost\":140,\"user_rating\":{\"average_rating\":4.4,\"votes\":2937},\"id\":317},{\"city\":\"Denver\",\"name\":\"Joey's Pizza\",\"estimated_cost\":80,\"user_rating\":{\"average_rating\":4.6,\"votes\":6909},\"id\":318},{\"city\":\"Denver\",\"name\":\"Chili's American Grill & Bar\",\"estimated_cost\":140,\"user_rating\":{\"average_rating\":4.6,\"votes\":6814},\"id\":319},{\"city\":\"Denver\",\"name\":\"Vedge\",\"estimated_cost\":10,\"user_rating\":{\"average_rating\":4.7,\"votes\":3837},\"id\":320}]}";
		JSONObject json = new JSONObject(jsonString);
		List<String> output = arrayToStream(json.getJSONArray("data"))
				.filter(dataObj -> dataObj.getInt("estimated_cost") <= maxCostOf2Person)
				.map(dataObj -> dataObj.getString("name")).collect(Collectors.toList());
		System.out.println(output);
		System.out.println("=========================================");
	}

	private static void stringBufferBehaviour() {
		System.out.println("> string buffer when setCharAt(int,char) is used");
		String s = "art";
		int[] indices = { 1, 0, 2 };
		// StringBuilder sb = new StringBuilder(s.length()); // will throw error while
		// setting char
		StringBuilder sb = new StringBuilder(s.toString());
		for (int i = 0; i < s.length(); i++) {
			sb.setCharAt(indices[i], s.charAt(i));
		}
		System.out.println(sb.toString());
		System.out.println("=========================================");
	}

	private static void finallyBehaviorWhenTryReturns() {
		System.out.println("> finally behavior when try returns");
		class A {
			private int divide(int a, int b) {
				try {
					return a / b;
				} finally {
					System.out.println("Divison is over!");
				}
			}

			void divideCarefully(int a, int b) {
				try {
					divide(a, b);
				} catch (Exception e) {
					System.out.println("Division call is over!");
				}
			}
		}

		new A().divideCarefully(10, 0);
		System.out.println("=========================================");
	}

	private static void childClassAlsoGetsInstanceOfParent() {
		class A {
			int a;

			A() {
				a = 10;
			}
		}

		class B extends A {
//			B() {
//				super();
//			}

			void printParentInstance() {
				System.out.println(a);
			}
		}

		System.out.println("> accessing parent instance variable through child");
		new B().printParentInstance();
		System.out.println("=========================================");
	}

	private static void arrayIsAnObject() {
		System.out.println("> arrays are classes");
		System.out.println("Class name for 1D int array: " + (new int[1]).getClass().getName());
		System.out.println("Class name for 2D long array: " + (new long[1][1]).getClass().getName());
		System.out.println("Class name for 1D bool array: " + (new boolean[1]).getClass().getName());
		System.out.println("=========================================");
	}

	private static void intArrToList() {
		int arr[] = { 2, 3, 4, 5 };
		System.out.println("> int[] to List conversion by indexed assignment");
		System.out.println(Arrays.asList(arr[0], arr[1], arr[2], arr[3]));
		System.out.println("> int[] to List conversion directly using stream");
		System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		System.out.println("> OR if you are simply printing it, no need of boxing");
		Arrays.stream(arr).forEach(e -> System.out.print(e + ", "));
		System.out.println("\n=========================================");
	}

	private static void intToStringConversion() {
		System.out.println("> int to string conversion");
		System.out.print(1 + 2 + "");
		System.out.print(" is not same as ");
		System.out.println("" + 1 + 2);
		System.out.println("=========================================");
	}

}
