import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("cinema.lib")
@IncludeTags({"valid"})
public class SuiteTest {
}
