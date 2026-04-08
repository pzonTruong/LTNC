// 3. Adapter: Cầu nối giữa Sorter và LegacySorter
class SorterAdapter implements Sorter {
    private LegacySorter legacySorter;

    public SorterAdapter(LegacySorter legacySorter) {
        this.legacySorter = legacySorter;
    }

    @Override
    public int[] sort(int[] arr) {
        // Chuyển đổi lời gọi từ interface mới sang thư viện cũ
        return legacySorter.quickSort(arr);
    }
}