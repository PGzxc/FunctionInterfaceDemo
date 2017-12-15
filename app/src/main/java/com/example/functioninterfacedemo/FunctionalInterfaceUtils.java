package com.example.functioninterfacedemo;

import com.example.functioninterfacedemo.bean.Artist;
import com.example.functioninterfacedemo.bean.Person;
import com.example.functioninterfacedemo.toast.ToastUtils;

import java.time.Clock;
import java.time.Instant;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceUtils {
	
	//Predicate接口
	public static void predicate() {
		
		Predicate<String> predicate = (s) -> s.length() > 0;
		System.out.println(predicate.test("foo")); // true
		System.out.println(predicate.negate().test("foo")); // false
		ToastUtils.showToast("predicate.test()="+predicate.test("foo"));
		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;
		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
		System.out.println(nonNull+""+isNull+""+isEmpty+""+isNotEmpty);

	}
	public static void function() {
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);
		System.out.println(backToString.apply("123")); // "123"
		ToastUtils.showToast(backToString.apply("123"));
		
	}
	public static void supplier() {
		Supplier<Artist> personSupplier = Artist::new;
		System.out.println(personSupplier.get());   // new Person
		ToastUtils.showToast(personSupplier.get()!=null?personSupplier.get().toString():"null");
	}

	public static void consumer() {
		
		Consumer<Person> greeter =(p) -> System.out.println("Hello, " + p.getName());
		greeter.accept(new Person("Lucy", 18));
		ToastUtils.showToast(new Person("Lucy", 18).toString());
	}
	public static void comparators() {
		
		Comparator<Person> comparator = (p1, p2) -> p1.getName().compareTo(p2.getName());
		Person p1 = new Person("John", 18);  
		Person p2 = new Person("Alice", 20);  
		System.out.println(comparator.compare(p1, p2));// > 0  
		System.out.println(comparator.reversed().compare(p1, p2));  // < 0
		ToastUtils.showToast("comparator.compare(p1, p2)="+comparator.compare(p1, p2));
	}
	
	public static void optionals() {
		Optional<String> optional = Optional.of("bam");   
		System.out.println(optional.isPresent());// true  
		System.out.println(optional.get());// "bam"
		ToastUtils.showToast(optional.get());
		System.out.println(optional.orElse("fallback"));// “bam”  如果为空则返回“fallback” 
		optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"  
	}
	public static void clock() {
		Clock clock = Clock.systemDefaultZone();
	    long millis = clock.millis();
	    System.out.println(millis);
	    Instant instant = clock.instant();
	    Date legacyDate = Date.from(instant);   // legacy java.util.Date
	    System.out.println(legacyDate);
		ToastUtils.showToast(legacyDate.toString());
	}
	
}
