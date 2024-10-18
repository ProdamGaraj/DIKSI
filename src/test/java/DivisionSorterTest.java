import org.example.DivisionSorter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class DivisionSorterTest {

    @Test
    public void testCompleteAndSortDivisions_SimpleCase() {
        List<String> codes = List.of(
                "K2\\SK1\\SSK1",
                "K1\\SK2",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1",
                "K2\\SK1\\SSK2",
                "K2"
        );

        List<String> expected = List.of(
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2"
        );

        List<String> result = DivisionSorter.completeAndSortDivisions(codes);
        assertEquals(expected, result);
    }

    @Test
    public void testCompleteAndSortDivisions_MissingParentDepartments() {
        List<String> codes = List.of(
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
                "K1\\SK1\\SSK2"
        );

        List<String> expected = List.of(
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK2"
        );

        List<String> result = DivisionSorter.completeAndSortDivisions(codes);
        assertEquals(expected, result);
    }

    @Test
    public void testCompleteAndSortDivisions_EmptyInput() {
        List<String> codes = List.of();
        List<String> result = DivisionSorter.completeAndSortDivisions(codes);
        assertTrue(result.isEmpty(), "Result should be empty for empty input");
    }

    @Test
    public void testCompleteAndSortDivisions_SingleDepartment() {
        List<String> codes = List.of("K1\\SK1\\SSK1");
        List<String> expected = List.of("K1", "K1\\SK1", "K1\\SK1\\SSK1");

        List<String> result = DivisionSorter.completeAndSortDivisions(codes);
        assertEquals(expected, result);
    }

    @Test
    public void testCompleteAndSortDivisions_MultipleMainDepartments() {
        List<String> codes = List.of(
                "K3\\SK1\\SSK1",
                "K1\\SK2",
                "K2\\SK1\\SSK2",
                "K2",
                "K3"
        );

        List<String> expected = List.of(
                "K3",
                "K3\\SK1",
                "K3\\SK1\\SSK1",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K1",
                "K1\\SK2"
        );

        List<String> result = DivisionSorter.completeAndSortDivisions(codes);
        assertEquals(expected, result);
    }

    @Test
    public void testCompleteAndSortDivisions_AllTopLevelMissing() {
        List<String> codes = List.of(
                "K3\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        );

        List<String> expected = List.of(
                "K3",
                "K3\\SK1",
                "K3\\SK1\\SSK1",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1"
        );

        List<String> result = DivisionSorter.completeAndSortDivisions(codes);
        assertEquals(expected, result);
    }

    @Test
    public void testCompleteAndSortDivisions_NestedWithoutTopLevel() {
        List<String> codes = List.of(
                "K3\\SK1",
                "K2\\SK2\\SSK1",
                "K1\\SK1\\SSK1",
                "K2\\SK2"
        );

        List<String> expected = List.of(
                "K3",
                "K3\\SK1",
                "K2",
                "K2\\SK2",
                "K2\\SK2\\SSK1",
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1"
        );

        List<String> result = DivisionSorter.completeAndSortDivisions(codes);
        assertEquals(expected, result);
    }

    @Test
    public void testCompleteAndSortDivisions_AllLevelsPresent() {
        List<String> codes = List.of(
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K3",
                "K3\\SK1",
                "K3\\SK1\\SSK1"
        );

        List<String> expected = List.of(
                "K3",
                "K3\\SK1",
                "K3\\SK1\\SSK1",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1"
        );

        List<String> result = DivisionSorter.completeAndSortDivisions(codes);
        assertEquals(expected, result);
    }

    @Test
    public void testCompleteAndSortDivisions_DifferentStructures() {
        List<String> codes = List.of(
                "K1\\SK1\\SSK1",
                "K2\\SK1",
                "K2\\SK2",
                "K3"
        );

        List<String> expected = List.of(
                "K3",
                "K2",
                "K2\\SK1",
                "K2\\SK2",
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1"
        );

        List<String> result = DivisionSorter.completeAndSortDivisions(codes);
        assertEquals(expected, result);
    }

    @Test
    public void testCompleteAndSortDivisions_SingleTopLevel() {
        List<String> codes = List.of("K1");
        List<String> expected = List.of("K1");

        List<String> result = DivisionSorter.completeAndSortDivisions(codes);
        assertEquals(expected, result);
    }
}
