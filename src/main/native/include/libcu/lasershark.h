#include <frc/DigitalSource.h>
#include <frc/DutyCycle.h>

namespace libcu
{
class Lasershark
{
public:
    explicit Lasershark(frc::DigitalSource &source);
    explicit Lasershark(frc::DigitalSource *source);
    explicit Lasershark(std::shared_ptr<frc::DigitalSource> source);

    double GetDistanceFeet();
    double GetDistanceInches();
    double GetDisctanceCentimeters();

private:
    frc::DutyCycle *pwmInput;
};
} // namespace libcu
