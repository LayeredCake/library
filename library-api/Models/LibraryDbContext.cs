using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace LibraryAPI.Models
{
    public class LibraryDbContext : DbContext
    {

        public LibraryDbContext(DbContextOptions<LibraryDbContext> options) : base(options){ }
        public DbSet<Book> Books { get; set; } = null;
        public DbSet<User> Users { get; set; } = null;

    }
}
