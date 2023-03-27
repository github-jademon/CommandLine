import java.io.File;
import java.text.SimpleDateFormat;

public class CommandLs extends AbstractCommand {

	protected File[] directories = currentDirectory.listFiles();
	protected String[] directoriesName = currentDirectory.list();

	public CommandLs(File currentDirectory, String commandLine) {
		super(currentDirectory, commandLine);
	}

	@Override
	public File executeCommand() {
		if (directories != null) {
			System.out.println("\nThe " + directories.length + " items in the directory " + currentDirectory.getName() + " are:");
			for (int i = 0; i < directories.length; i++) {
				String lastModifiedTime = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss").format(directories[i].lastModified());
				long size = directories[i].length();
				System.out.printf("%s %5s %7s %s\n", lastModifiedTime, (directories[i].isDirectory()?"<DIR>":""), (directories[i].isDirectory()?"":(size > 10000 ? size/1024 > 10000 ?
						size/1024/1024 > 10000 ? size/1024/1024/1024 + "G" : size/1024/1024 + "K" : size/1024 : size + "B")), directoriesName[i]);
			}
		} else {
			System.out.println(currentDirectory.getName() + " is not a directory");
		}
//		System.out.println(currentDirectory + " " + commandLine);
		return currentDirectory;
	}

}