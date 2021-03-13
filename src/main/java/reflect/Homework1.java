package reflect;

import java.lang.reflect.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;

public class Homework1 {

    /**
     * Prints the declared methods of java.lang.String sorted by name.
     */
    public void streamPipeline1() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods()).map(x->x.getName()).sorted().forEach(System.out::println);

    }

    /**
     *  Prints all distinct names of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline2() {
	Arrays.stream(java.lang.String.class.getDeclaredMethods()).map(x->x.getName()).sorted().distinct().forEach(System.out::println);

    }

    /**
     * Prints the declared methods of java.lang.String with two or more parameters whose parameters are all of the same type, sorted by name.
     */
    public void streamPipeline3() {
	Arrays.stream(java.lang.String.class.getDeclaredMethods()).filter(x->x.getParameterCount()>1 && (Arrays.stream(x.getParameterTypes()).distinct().count())==1).map(x->x.getName()).sorted().forEach(System.out::println);

 
    }

    /**
     * Prints all distinct return types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline4() {
	Arrays.stream(java.lang.String.class.getDeclaredMethods()).map(x->x.getReturnType().getName()).distinct().sorted().forEach(System.out::println);

    }

    /**
     * Prints the declared methods of java.lang.String with at least one boolean parameter, sorted by name.
     */
    public void streamPipeline5() {
	Arrays.stream(java.lang.String.class.getDeclaredMethods()).filter(x->(Arrays.stream(x.getParameterTypes()).map(y->y.getName()).anyMatch(y->y=="boolean"))).map(x->x.getName()).sorted().forEach(System.out::println);

    }

    /**
     * Prints the declared methods of java.lang.String whose parameters are all of type int, sorted by name.
     */
    public void streamPipeline6() {
	Arrays.stream(java.lang.String.class.getDeclaredMethods()).filter(x->(Arrays.stream(x.getParameterTypes()).map(y->y.getName()).allMatch(y->y=="int"))).map(x->x.getName()).sorted().forEach(System.out::println);

    }

    /**
     * Returns the longest name of the declared methods of java.lang.String.
     */
    public String streamPipeline7() {


        return Arrays.stream(java.lang.String.class.getDeclaredMethods()).map(x->x.getName()).sorted((x,y)-> ((Integer) y.length()).compareTo((Integer) x.length())).limit(1).findAny().get();
    }

    /**
     *  Returns the longest one from the names of the public declared methods of java.lang.String.
     */
    public String streamPipeline8() {
       return Arrays.stream(java.lang.String.class.getDeclaredMethods()).filter(x->Modifier.isPublic(x.getModifiers())).map(x->x.getName()).sorted((x,y)-> ((Integer) y.length()).compareTo((Integer) x.length())).limit(1).findAny().get();

    }

    /**
     * Returns summary statistics about the number of parameters for the declared methods of java.lang.String.
     */
    public IntSummaryStatistics streamPipeline9() {

        return Arrays.stream(java.lang.String.class.getDeclaredMethods()).mapToInt(x->x.getParameterCount()).summaryStatistics();
    }

    /**
     * Returns the maximum number of parameters accepted by the declared methods of java.lang.String.
     */
    public int streamPipeline10() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods()).mapToInt(x->x.getParameterCount()).max().orElse(0);
    }

    /**
     * Returns the declared method of java.lang.String with the most number of parameters.
     */
    public Method streamPipeline11() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods()).filter(x->Arrays.stream(java.lang.String.class.getDeclaredMethods()).mapToInt(y->y.getParameterCount()).max().orElse(0)==x.getParameterCount()).limit(1).findAny().get();

    }

    /**
     * Prints all distinct parameter types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline12() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods()).flatMap(x->Arrays.stream(x.getParameterTypes())).map(x->x.getName()).distinct().sorted().forEach(System.out::println);

    }

}
