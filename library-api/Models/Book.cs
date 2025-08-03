namespace LibraryAPI.Models;

public enum GenresEnum {
    FANTASY,
    SCIENCEFICTION,
    LITERATURE,
    NONFICTION,
    OTHER
}
public enum ConditionsEnum
{
    NEW,
    GOOD,
    BAD,
    UNKNOWN
}
public enum FormatsEnum
{
    PAPERBACK,
    HARDCOVER
}
public class Book
{
    public int Id { get; set; }
    public string Title { get; set; }
    public string Author { get; set; }
    public string Series { get; set; }
    public int? PageCount { get; set; }
    public string Owner { get; set; }
    public GenresEnum? Genre { get; set; }
    public string CurrentHolder { get; set; }
    public ConditionsEnum? Condition { get; set; }
    public FormatsEnum? Format { get; set; }


}
